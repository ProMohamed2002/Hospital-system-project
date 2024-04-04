package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Appointment;
import com.Healthcare.Healthcare.Entity.WorkingHours;
import com.Healthcare.Healthcare.Repository.AppointmentRepo;
import com.Healthcare.Healthcare.Repository.WorkingHoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class AppointmentService {
    @Autowired
    private WorkingHoursRepo workingHoursRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> fetchAllAppointments() {
        return appointmentRepo.fetchAllFromCustom();
    }

    public List<Appointment> fetchAppointmentsUsingDoctorAndWeek(String doctor, String weekDay) {
        return appointmentRepo.fetchAppointmentsUsingDoctorAndWeek(doctor, weekDay);
    }
    public List<Appointment> fetchAppointmentsUsingDoctor(String doctor) {

        List<Appointment> filterPastAppointments = appointmentRepo.fetchAppointmentsUsingDoctor(doctor);
        List<Appointment> filtered=new ArrayList<>();
        // Create a LocalDate
        LocalDate localDate = LocalDate.now();
        // Convert LocalDate to java.sql.Date
        Date sqlDate = java.sql.Date.valueOf(localDate);
        for (Appointment ap:filterPastAppointments){
            if(!(sqlDate.after(ap.getBooking_date())))
            {
                filtered.add(ap);
            }
        }
            return filtered;
    }

    public void deleteAppointmentByDoctorAndDay(String doctor, String day) {
        appointmentRepo.deleteAppointmentByDoctorAndDay(doctor, day);
    }
    public List<Appointment> getfreeAppointment(String doctor)
    {

       List<Appointment>unBoookedappointments=new ArrayList<>();
       List<WorkingHours>WeekWorkinghours=workingHoursRepo.fetchWorkingHoursUsingDoctor(doctor);
       List<Appointment>Bookedappointments=appointmentRepo.fetchAppointmentsUsingDoctor(doctor);
       List<List<Appointment>>l= new ArrayList<>();
       for(WorkingHours w:WeekWorkinghours)
       {
           for(int i=0;i<7;i++) {

               if(w.getWeek_day().equals(getDayOfWeek(combineDateAndTime(getCurrnetDays(i),w.getWork_start()))))
               l.add(makeAppointments(w, getCurrnetDays(i)));

           }


       }
        boolean c=false;
       int x=0;
       for (int i=0;i<l.size();i++) {
           System.out.println(l.size());
           for (Appointment a : l.get(i))
           {
               if(Bookedappointments.size()==0)
               {
                     c=true;
               }
               System.out.println(l.get(i).size());
              for(Appointment ba:Bookedappointments)
              {
                  System.out.println(Bookedappointments.size());
                  System.out.println(a.getSession_start());
                  System.out.println(ba.getSession_start());
                  if(!a.getSession_start().equals(ba.getSession_start()))
                  {

                       c =true;
                      System.out.println("iterate"+"at 80");
                  }
                  else
                  {
                      c=false;
                      break;
                  }
              }
              if(c){
               unBoookedappointments.add(a);
                  System.out.println("added"+x);
                  x++;
                  c=false;
           }
           }
       }

        return unBoookedappointments;

    }
    public Date getCurrnetDays(int d)
    {
        Calendar currentCalendar = Calendar.getInstance();

        // Add 5 days to the current date
        currentCalendar.add(Calendar.DAY_OF_YEAR,d);

        // Convert Calendar to Date
        java.util.Date currentDate = currentCalendar.getTime();

        // Define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Format the date as a string
        String formattedDate = dateFormat.format(currentDate);


        try {
            // Parse the string to get a Date object
            java.util.Date parsedDate = dateFormat.parse(formattedDate);

            System.out.println("Formatted Date String: " + formattedDate);
            System.out.println("Parsed Date: " + parsedDate);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            return sqlDate;
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
return null;
    }
//    List<Appointment> getWeekBookedAppointment(String doctor)
//    {
//        List<Appointment>Bookedappointments=appointmentRepo.fetchAppointmentsUsingDoctor(doctor);
//        List<Appointment>Bookedappointments2=new ArrayList<>();
//        for(Appointment a:Bookedappointments )
//        {
//            for(int i=0;i<7;i++){
//            if(a.getBooking_date().equals(getCurrnetDays(i)))
//            {
//                Bookedappointments2.add(a);
//            }
//        }
//
//        }
//        return Bookedappointments2;
//
//    }
    private List<Appointment> makeAppointments(WorkingHours w,Date date)
    {
        List<Appointment>l=new ArrayList<>();
        WorkingHours ww=w;


        while(ww.getWork_start().before(ww.getWork_end()))
        {
            Time t1=ww.getWork_start();
            ww.setWork_start(addMinutesToTime(ww.getWork_start(),15));
            System.out.println(ww.getWork_start());
           Time t2=ww.getWork_start();
            Timestamp timestampstart = combineDateAndTime(date, t1);
            Timestamp timestampend = combineDateAndTime(date, t2);
           l.add(new Appointment(0,date,0,timestampstart,timestampend,"unknown","unknown",w.getWeek_day(),0));
            System.out.println("iterate"+"at 141");

        }
return l;
    }
    private static Time addMinutesToTime(Time time, int minutesToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MINUTE, minutesToAdd);
        return new Time(calendar.getTimeInMillis());
    }
    private static Timestamp combineDateAndTime(Date date, Time time) {
        // Get the time in milliseconds from Date and Time
        long dateTimeMillis = date.getTime() + time.getTime();

        // Create Timestamp from the combined milliseconds
        return new Timestamp(dateTimeMillis);
    }
    private static String getDayOfWeek(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(timestamp);
    }
}

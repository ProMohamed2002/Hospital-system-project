<template>
    <div>
      <div class="slider">
    <img src="../assets/a.jpg" alt="Image 1">
    <div class="description"><p>«الصحة» توقع بروتوكولا لإنشاء منصة تخزين وأرشفة صور الأشعة والتقارير</p></div>
    <img src="../assets/b.jpg">
    <div class="description"><p>وزارة الصحة تنظم ورشة عمل حول تطوير الاستراتيجية الوطنية للقبالة</p></div>
    <img src="../assets/c.jpg" alt="Image 3">
    <div class="description"><p>جولة لوكيل وزارة الصحة على المنشآت الطبية بغرب الإسكندرية</p></div>
    <div class="arrow left"><i class="fa-solid fa-angle-left"></i></div>
    <div class="arrow right"><i class="fa-solid fa-angle-left fa-rotate-180"></i></div>
      </div>
      <div class="container">
        <div class="element">
          <div class="box">
            <i class="fa-sharp fa-solid fa-question fa-beat-fade fa-lg" style="font-size: 83px;color: #fff;padding-top: 45px;"></i>
            <h1>طريقة التسجيل في الموقع </h1>
            <p ><a href="" style="color: yellow;text-decoration: none;"> يتيح لك الموقع الكثير من الصلاحيات </a></p>
          </div>
          <div class="box">
            <i class="fa-solid fa-hands-holding-child" style="font-size: 80px;color: #fff;"></i>
            <h1>الموارد التعليمية و النصائح العامة للمرضى</h1>
            <p><a href="" style="color:yellow;text-decoration: none;"> تعرف على الجديد </a></p>
          </div>
          <div class="box">
            <i class="fa-solid fa-users" style="font-size: 80px;color: #fff;"></i>
            <h1>التواصل مع مطوري الموقع</h1>
            <p><a href="" style="color: yellow;text-decoration: none;"> اضغط هنا </a></p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HoMe',
    mounted() {
      // JavaScript code for slider functionality
      var images = document.querySelectorAll('.slider img');
      var descriptions = document.querySelectorAll('.slider .description');
      var currentIndex = 0;
  
      function showImage(index) {
        if (index < 0) {
          index = images.length - 1;
        } else if (index >= images.length) {
          index = 0;
        }
  
        for (var i = 0; i < images.length; i++) {
          images[i].style.display = 'none';
          descriptions[i].style.display = 'none';
        }
  
        images[index].style.display = 'block';
        descriptions[index].style.display = 'block';
        currentIndex = index;
      }
  
      function showNextImage() {
        showImage(currentIndex + 1);
      }
  
      function showPreviousImage() {
        showImage(currentIndex - 1);
      }
  
      document.querySelector('.arrow.left').addEventListener('click', showPreviousImage);
      document.querySelector('.arrow.right').addEventListener('click', showNextImage);
  
      showImage(currentIndex);
    },
  };
  </script>
  
  <style scoped>
  .slider {
    position: relative;
    max-width: 1170px;
    margin: auto;
    height: 600px;
    overflow: hidden;
  }

  .slider img {
    width: 100%;
    height: 100%;
  }

  .slider .arrow {
    position: absolute;
    top: 50%;
    transform: translateY(-50%,-50%);
    width: 50px;
    height: 60px;
    background-color: #0f0d0d;
    color: #fff;
    font-size: 24px;
    padding: 0;
    text-align: center;
    cursor: pointer;
    opacity: 0.7;
  }
  .slider .arrow.left {
    left: 10px;
    font-size: 60px;
    transition: 0.2s;
    
  }

  .slider .arrow.right {
    right: 10px;
    font-size: 60px;
   
  }

  .slider .description {
  background-color: #0f0d0d;
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 90px;
    text-align: center;
    color: rgb(248, 242, 242);
    font-size: 18px;
    font-weight: bold;
    opacity:0.7 ;
  
  }
  .container{
    width: 100%;
    position: relative;
    margin-top: 50px;
    overflow: hidden;
    
  }
  .element{
    display: grid;
    gap: 20px;
    left: 0;
    grid-template-columns: repeat(3,1fr);
  }
  .box{
    border:#0f0d0d solid 2px; 
    background-color:#1376ab ;
    width: auto;
    height: 280px;
    text-align: center;
    padding-top: 50px;
    max-width: 600px;
    text-align: center;
    padding-left: 0;
    line-height: 1.5;
  }
  h1{
    color: #fff;
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
    
  }
  </style>
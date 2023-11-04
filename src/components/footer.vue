<template>
    <footer class="footer">
        <div class="container1">
            <div class="row">
            <div class="footer-col">
                <h4>department</h4>
                <ul>
                    <li><a href="#">Dental Center</a></li>
                    <li><a href="#">Pediatrics Dep</a></li>
                    <li><a href="#">Obstetrics and Gynecology Dep</a></li>
                    <li><a href="#">General Surgery Dep</a></li>
                    <li><a href="#">Nephrology Dep</a></li>
                    <li><a href="#">Neurosurgery Dep</a></li>
                    <li><a href="#">Ear, Nose and Throat Dep</a></li>
                </ul>
            </div>
            <div class="footer-col">
                <h4>Address</h4>
                <div class="img-size">
                    <a href="#"><img src="../assets/map.jpg" alt="no" ></a>
                </div>
            </div>
            <div class="footer-col">
                <h4>follow us</h4>
                <div class="social">
                    <a href="#"><i class="fa-brands fa-facebook" style="font-size:30px"></i></a>
                    <a href="#"><i class="fa-brands fa-youtube" style="font-size:30px"></i></a>
                    <a href="#"><i class="fa-brands fa-twitter" style="font-size:30px"></i></a>
                    <a href="#"><i class="fa-brands fa-instagram" style="font-size:30px"></i></a>
            </div>
            </div>
        </div>
    </div>
    </footer>
</template>
<script>
export default{
    name:'FooTer'
}

</script>
<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
.container1{
    max-width: 100%;
    margin: auto;
    padding-left:195px ;
}
.footer .container1 ul{
    list-style: none;
}
.row{
    display: flex;
    flex-wrap: wrap;
    gap:5px;
}
.footer{
    background-color: #2f3135;
    padding: 70px 0;

}
.footer-col{
    width: 33%;
    padding:0 33px;

}
.footer-col h4{
    font-size: 18px;
    color: #fff;
    text-transform: capitalize;
    margin-bottom: 35px;
    font-weight: 500;
    position: relative;
}
.footer-col h4::before{
    content: '';
    position:absolute;
    left:0;
    bottom: -10px;
    background-color: #1376ab;
    height: 2px;
    box-sizing: border-box;
    width: 50px;

}
.footer-col ul li{
    padding-top:3px;
}
.footer-col ul li a{
    font-size: 16px;
    text-transform: capitalize;
    color: #ffffffff;
    text-decoration: none;
    font-weight: 300;
    color: #bbbbbb;
    display: block;
    transition: all 0.3s ease;


}
.img-size{
    width:400px;
    height:200px;
    position: relative;

}
.footer img{
    position: absolute;
    width:200px;
    height:100px;
}
.footer-col ul li a:hover{
    color:#ffffffff;
    padding-left: 8px;
}
.footer-col .social a{
    display: inline-block;
    margin:0  10px 10px 0;
    text-align: center;
    line-height: 40px;
    color: #bbbbbb;
    transition: all 0.5s ease;


} 
.footer-col .social a:hover{
    color:#ffffff;

}
@media(max-width: 574){

    
}



</style>
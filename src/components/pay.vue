<template>
  <main_header/>
<div class="container">
    <div class="f">
    <button type="button" class="btn btn-primary launch" data-toggle="modal" data-target="#staticBackdrop" >  Pay Now
    </button>
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog"> <div class="modal-content"> <div class="modal-body"> <div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div> <div class="tabs mt-3"> <ul class="nav nav-tabs" id="myTab" role="tablist">       <li class="nav-item" role="presentation">  <a class="nav-link active" id="visa-tab" data-toggle="tab" href="#visa" role="tab" aria-controls="visa" aria-selected="true"><img src="https://i.imgur.com/sB4jftM.png" width="80"> </a></li> <li class="nav-item" role="presentation"><a class="nav-link" id="paypal-tab" data-toggle="tab" href="#paypal" role="tab" aria-controls="paypal" aria-selected="false"><img src="https://i.imgur.com/yK7EDD1.png" width="80"></a></li> </ul>  <div class="tab-content" id="myTabContent"> <div class="tab-pane fade show active" id="visa" role="tabpanel" aria-labelledby="visa-tab"> <div class="mt-4 mx-4"> <div class="text-center"> <h5>Credit card</h5> </div> <div class="form mt-3"> <div class="inputbox"> <input type="text" name="name" class="form-control" required="required"> <span>Cardholder Name</span> </div> <div class="inputbox"> <input type="text" name="name" min="1" max="999" class="form-control" required="required"> <span>Card Number</span> <i class="fa fa-eye"></i> </div> <div class="d-flex flex-row"> <div class="inputbox"> <input type="text" name="name" min="1" max="999" class="form-control" required="required"> <span>Expiration Date</span> </div> <div class="inputbox"> <input type="text" name="name" min="1" max="999" class="form-control" required="required"> <span>CVV</span> </div> </div> <div class="px-5 pay"> <button class="btn btn-success btn-block">Add card</button> </div> </div> </div> </div> <div class="tab-pane fade" id="paypal" role="tabpanel" aria-labelledby="paypal-tab"> <div class="px-5 mt-5"> <div class="inputbox"> <input type="text" name="name" class="form-control" required="required"> <span>Paypal Email Address</span> </div> <div class="pay px-5"> <button class="btn btn-primary btn-block">Add paypal</button> </div> </div> </div> </div> </div> </div> </div> </div>
    </div>
    <label style="color:#0d6efd">Wayes of PayMent</label>
    </div>
    <div class="s">
      <input type="checkbox" style="">
      <label style="color:#0d6efd">health insurance</label>
    </div>
    </div>
    <FooTer/>
</template>

<script>
 import main_header from "./header.vue" 
 import FooTer from "./footer.vue" 

export default {
  name: 'PayMent',
  components:{
            main_header,
            FooTer
        },

}
</script>
<style scoped>
.container {
    padding-left: 15px;
    padding-right: 15px;
    height: 600px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 50px;
    margin-bottom: 50px;
    

  }
  body{height: 100vh;justify-content: center;align-items: center;display: flex;background-color: #eee}.launch{height: 50px}.close{font-size: 21px;cursor: pointer}.modal-body{height: 450px}.nav-tabs{border:none !important}.nav-tabs .nav-link.active{color: #495057;background-color: #fff;border-color: #ffffff #ffffff #fff;border-top: 3px solid blue !important}.nav-tabs .nav-link{margin-bottom: -1px;border: 1px solid transparent;border-top-left-radius: 0rem;border-top-right-radius: 0rem;border-top: 3px solid #eee;font-size: 20px}.nav-tabs .nav-link:hover{border-color: #e9ecef #ffffff #ffffff}.nav-tabs{display: table !important;width: 100%}.nav-item{display: table-cell}.form-control{border-bottom: 1px solid #eee !important;border:none;font-weight: 600}.form-control:focus{color: #495057;background-color: #fff;border-color: #8bbafe;outline: 0;box-shadow: none}.inputbox{position: relative;margin-bottom: 20px;width: 100%}.inputbox span{position: absolute;top:7px;left: 11px;transition: 0.5s}.inputbox i{position: absolute;top: 13px;right: 8px;transition: 0.5s;color: #3F51B5}input::-webkit-outer-spin-button, input::-webkit-inner-spin-button{-webkit-appearance: none;margin: 0}.inputbox input:focus~span{transform: translateX(-0px) translateY(-15px);font-size: 12px}.inputbox input:valid~span{transform: translateX(-0px) translateY(-15px);font-size: 12px}.pay button{height: 47px;border-radius: 37px}
  .btn-primary {
    color: #0d6efd;
    background-color: #2c3e50;
    border-color: #0d6efd;
  }
  .container .f {
    text-align:center;
    
    margin-bottom: 50px;
  }
  .container .s {
    text-align: center ;

  }
  label{
    margin-left: 25px;
    font-weight: bold;
    font-size: 37px;
    color: #ffffff;

  }
/* Small */
@media (min-width: 768px) {
    .container {
      width: 750px;
    }
  }
  /* Medium */
  @media (min-width: 992px) {
    .container {
      width: 970px;
    }
  }
  /* Large */
  @media (min-width: 1200px) {
    .container {
      width: 1170px;
    }
  }

</style>

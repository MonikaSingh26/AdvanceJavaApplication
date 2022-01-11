<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>

<body>
<form action = "login" method="post">
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">

              <div class="mb-md-5 mt-md-4 pb-5">

                <h2 class="fw-bold mb-2 text-uppercase">LOGIN</h2>
                <p class="text-white-50 mb-6">Please Enter Your Login ID and Password</p>

                <div>
                    <form action="loginmodule">
                        <div class="form-outline form-white mb-4"></div>
                          <label for="InputEmail" class="form-label">Email Address</label>
                          <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address Here" name="email" required>
                          <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div class="form-outline form-white mb-4"></div>
                          <label for="InputPassword" class="form-label">Password</label>
                          <input type="password" class="form-control" id="InputPassword" placeholder="Enter Password Here" name="password" required>
                        </div>

                <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgotten your password?</a></p>

                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                <a class="btn btn-outline-light btn-lg px-5" href="/LoginController" role="button">Reset</a>

                <div class="d-flex justify-content-center text-center mt-4 pt-1">
                  <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                  <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                  <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                </div>

              </div>

              <div>
                <p class="mb-3">Don't have an account?<a href="#!" class="text-white-50 fw-bold">Signup</a></p>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

</body>
</html>


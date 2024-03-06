<?php
$action = (isset($_REQUEST['action']) ? $_REQUEST['action'] : 'login');
$message = '';
session_start();
?>

<!DOCTYPE HTML>
<html lang="en"> 
	<head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <title>Web App</title>
		<script>
			function sumbitForm() {
				var username = $("#username").val();
				var password = $("#password").val();

				if (password != '' || username != '') {
					var form = $("#loginform");
					form.submit();
				} else {
					alert("You need to provide a username and password.");
				}

			}

		</script>
	</head>
	<body>
		<div class="container">
			<div class="row bg-primary">
				<div class="col-sm-12 text-center p-3">
					<h3>Web App</h2>
				</div>
			</div>
			<?php

			if ($action == 'authenticate') {
				$db_servername = "localhost";
				$db_username = "root";
				$db_password = "mysql";
				$db_name = "webapp";

				$mysqli = new mysqli($db_servername, $db_username, $db_password, $db_name);

				$username = (isset($_REQUEST['username']) ? $_REQUEST['username'] : 'username');
				$password = (isset($_REQUEST['password']) ? $_REQUEST['password'] : 'password');

				// server side validation
				if ($username != null && $password != null) {

					$stmt = $mysqli->prepare("SELECT * FROM `users` WHERE `username` = ? AND `password` = ?");
					$stmt->bind_param("ss", $username, $password);
	
					$stmt->execute();
					$result = $stmt->get_result();
					$row = $result->fetch_assoc();
	
					if (isset($row)) {
						// if correct username and pwd, direct user to main menu
						$action = 'mainmenu';
						$_SESSION['loggedin'] = True;
						$_SESSION['username'] = $row['username'];
						$_SESSION['email'] = $row['email'];
						$_SESSION['firstname'] = $row['firstname'];
						$_SESSION['lastname'] = $row['lastname'];
					} else {
						// if login is incorrect , direct user login and tell them what happend.
						$action = "login";
						$message = "You botched your login, try again.";
					}
				} else {
					$action = "login";
					$message = "You need to provide a login.";
				}

			} else if ($action == 'logout') {
				session_unset();
				session_destroy();
				$action = 'login';
			}

			if ($action == 'mainmenu' && $_SESSION['loggedin'] == True) {

				$username = $_SESSION['username'];
				$email = $_SESSION['email'];
				$firstname = $_SESSION['firstname'];
				$lastname = $_SESSION['lastname'];

				echo "<h2>Main Menu</h2>";
				echo "<a>Welcome to our app " . $firstname . " " . $lastname . " </a>";
				echo "<a href='index.php?action=logout'>Logout</a>";
			} else if ($action == 'login') {
				?>
				<h4 class="text-success p-3"><em>Welcome to the application, please login.</em></h4>
				<?=$message?>
				<form id="loginForm" action="index.php" method="post">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="username" class="form-control" name="username" id="username" placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
					</div>					  
					<input type="hidden" name="action" value="authenticate"/>
					<button type="submit" class="btn btn-primary" onclick="sumbitForm()">Submit</button>
				</form>
				<?php
			}
			?>
		</div>
	</body>
</html>


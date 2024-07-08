/*var user = sessionStorage.getItem('user')

if(user ===  null){
	let username = prompt('Enter Your Name')
	while( username ===  null || username == ''){
	username = prompt('Enter Your Name')

	} 
	fetch(`/welcome/createUser`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: username
	}).then(response => response.json())
	.then(user => {
		sessionStorage.setItem('user', JSON.stringify(user))
		})
	
	} else {
		user = JSON.parse(sessionStorage.getItem('user'))
		sessionStorage.setItem('user', user)
		console.log(user)
	} */


/*const usernameInput = document.getElementById('username');
const username = usernameInput.value;

function promptForUsername() {
	let username = sessionStorage.getItem('username');
	
	if (username == null || username.trim() === '') {
		username = prompt('enter your username');
		
		if (username == null || username.trim() === ''){
		promptForUsername();
		
		fetch("/welcome/createUser", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: username
	    }).then(response => response.json()).then(user => sessionStorage.setItem("user", JSON.stringify(user)))
	
		} else {
			sessionStorage.setItem('username', username);
		}
	}
}

promptForUsername();*/

function setUsername() {
	const usernameInput = document.getElementById('username');
	const user = usernameInput.value;

	if (user.trim() !== '') {
		sessionStorage.setItem('user', user);
		window.location.href = '/channels'
	}
}


function promptForUsername() {
	var username = sessionStorage.getItem('username');

	if (username == null || username.trim() === '') {
		username = prompt('enter your username');

		if (username == null || username.trim() === '') {
			promptForUsername();
		} else {
			sessionStorage.setItem('username', username);
		}
	}
}
promptForUsername();
// need to figure out why new users are generated everytime you go back to the welcome page
//ok thisparts fine the other one i deleted as of 1/15 makes u do that ^
//at this checkpoint kinda just married the two different ways --1/15 but ye this is good now
let user = sessionStorage.getItem('user')

function setUsername() {
	const usernameInput = document.getElementById('username');
	const username = usernameInput.value;

	if (username.trim() !== '') {
		sessionStorage.setItem('username', username);
		window.location.href = '/channels'
	}
	fetch(`/welcome/createUser`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: username
	})
		.then(response => response.json())
		.then(user => {
			console.log(user)
			sessionStorage.setItem('username', JSON.stringify(user))
		})

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

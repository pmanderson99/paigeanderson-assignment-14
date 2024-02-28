const messageInput = document.getElementById('message-input');
const channelId = extractChannelIdFromUrl;
const messageText = messageInput.value;
const username = sessionStorage.getItem('username');
//const message = {
//	channelId, username, messageText
//};

//Function to handle sending a message
function sendMessage() {
  let message = messageInput.value.trim()
  messageInput.value.trim();
  if (message !== '') {
    const chatMessages = document.querySelector('.chat-messages');
    const messageElement = document.createElement('div');
    messageElement.classList.add('message');
    messageElement.textContent = username +': ' + message;
    chatMessages.appendChild(messageElement);
    messageInput.value = '';
    chatMessages.scrollTop = chatMessages.scrollHeight;
  }
}

// Event listener
document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
  if (event.key === 'Enter') {
    event.preventDefault();
    sendMessage();
  }
});

function extractChannelIdFromUrl() {
    var currentUrl = window.location.href;
    var segments = currentUrl.split('/');
    let channelId = segments[segments.length - 1];
    return channelId
    }

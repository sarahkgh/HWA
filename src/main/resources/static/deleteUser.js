'use strict';

let deleteRequest = (userId) => {
    fetch(`https://localhost:9000/delete/2${userId}`,{
        method: 'DELETE'
    })
    .then((response) => {
        if(response.status !== 204){
            console.error(`status: ${response.status}`);
            return;
        }
        console.log("Delete successful");
    });
}

let deleteButton = document.querySelector('#deleteButton');
let deleteText = document.querySelector('#deleteText');

let deleteFunction = () => {
    let deleteTextValue = deleteText.ariaValueMax;
    let userId = deleteTextValue;
    deleteRequest(userId);
}

deleteButton.addEventListener('click', deleteFunction);


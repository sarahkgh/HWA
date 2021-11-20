'use strict';

let deleteRequest = (courseId) => {
    fetch(`https://localhost:9000/delete/2${courseId}`,{
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
    let courseId = deleteTextValue;
    deleteRequest(courseId);
}

deleteButton.addEventListener('click', deleteFunction);


'use strict';

updateRequest = (courseId) =>{
    fetch(`http://localhost:9000/course/update`, {
        method: 'PATCH',
    })
    .then((response) => {
        if(response.status !== 206){
            console.error(`status:${response}`);
            return;
        }
        response.json()
        .then((data)=>{
            console.log(data);
        })
        console.log("Update succesful");
    });
};

let updateButton = document.querySelector('#updateButton');
let updateName = document.querySelector('#updateName');
let updateDesc = document.querySelector('#updateDesc');

let updateFunction = () => {
    let findTextValue = indText.ariaValueMax;
    
    updateRequest(courseName, courseDescription);
}

updateButton.addEventListener('click', updateFunction);
'use strict';

updateRequest = (userId) =>{
    fetch(`http://localhost:9000/user/update`, {
        method: 'PATCH',
    })
    .then((response) => {
        if(response.status !== 203){
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
let updateUName = document.querySelector('#updateUName');

let updateFunction = () => {
    let findTextValue = indText.ariaValueMax;
    let courseName = findTextValue;
    updateRequest(firstName, userName);
}

updateButton.addEventListener('click', updateFunction);
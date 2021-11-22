'use strict';

searchRequest = (userId) =>{
    fetch(`http://localhost:9000/user/get/1${userId}`, {
        method:'GET',
    })
    .then((response)=>{
        if(response.status !== 200){
            console.error(`status: ${response}`);
            return;
        }
        response.json()
        .then((data)=>{
            console.log(data);
        })
        .catch((error)=>{
            console.error(`${error}`);

        })

    });
}

let findButton = document.querySelector('#findButton');
let findText = document.querySelector('#findText');

let findFunction = () => {
    let findTextValue = findText.ariaValueMax;
    let userId = findTextValue;
    searchRequest(userId);
}

findButton.addEventListener('click', findFunction);
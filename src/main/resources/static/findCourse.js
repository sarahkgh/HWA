'use strict';

searchRequest = (courseId) =>{
    fetch(`https://localhost:9000/get/1${courseId}`, {
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
    let courseId = findTextValue;
    searchRequest(courseId);
}

findButton.addEventListener('click', findFunction);
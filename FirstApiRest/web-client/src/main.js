
async function getAll() {
    let response = await fetch(`http://localhost:8080/car`);
    let userData = await response.json();
    return userData
}

async function postCar(obj) {
    try {
        let response = await fetch('http://localhost:8080/car', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        });
        readAll();
    } catch (error) {
        console.error('Error adding car:', error);
    }
}

async function updateCar(obj) {
    try {
        let response = await fetch(`http://localhost:8080/car`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        });
        readAll();
    } catch (error) {
        console.error('Error updating car:', error);
    }
}

async function deleteCar(id) {
    try {
        let response = await fetch(`http://localhost:8080/car/${id}`, {
            method: 'DELETE'
        });
        readAll();
    } catch (error) {
        console.error('Error deleting car:', error);
    }
}



async function readAll(){
    data =  await getAll();
    var table = document.querySelector(".data_table");
    var elements = "";
    data.map(record =>{
        elements+=`
        <tr>
            <td>${record.name}</td>
            <td>${record.year}</td>
            <td>${record.color}</td>
            <td class="align_button_table">
                <button class="delete_button" onclick={deleteRecord(${record.id})}>Delete</button>
                <button class="update_button" onclick={edit(${record.id})}>Update</button>
            <td>
        <tr>    
        `
    })
    table.innerHTML = elements;
}

function create(){
    document.querySelector(".create_form").style.display = "block";
    document.querySelector(".add_div").style.display = "none";
}
async function add(){
    var name = document.querySelector(".name").value;
    var year = document.querySelector(".year").value;
    var color = document.querySelector(".color").value;
    obj = {
        name: name,
        year: Number(year),
        color: color,
    }
    
    add = await postCar(obj);
    document.querySelector(".create_form").style.display = "none";
    document.querySelector(".add_div").style.display = "block";

    readAll();
}

function edit(id){
    document.querySelector(".update_form").style.display = "block";
    var obj = data.find(rec => rec.id === id);
    document.querySelector(".uname").value = obj.name;
    document.querySelector(".uyear").value = obj.year;
    document.querySelector(".ucolor").value = obj.color;
    document.querySelector(".uid").value = obj.id;
}

async function update(){
    var id = document.querySelector(".uid").value;
    var name = document.querySelector(".uname").value;
    var year = document.querySelector(".uyear").value;
    var color = document.querySelector(".ucolor").value;
    let objeUpdate  = {
        id: id,
        name: name,
        year: year,
        color: color,
    }
    update = await updateCar(objeUpdate);
    document.querySelector(".update_form").style.display = "none";
    readAll();
}

async function deleteRecord(id){
    data = await deleteCar(id);
    readAll();
}
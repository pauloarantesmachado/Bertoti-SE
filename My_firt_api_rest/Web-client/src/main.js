let data = [
    {id: 1, name: "Camaro", year: 2016, color:"black"},
    {id: 2, name: "Mustang", year: 2017, color:"red"},
    {id: 3, name: "Charger", year: 2018, color:"red"},
    {id: 4, name: "Charger", year: 2018, color:"blue"},
]


function readAll(){
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
function add(){
    var name = document.querySelector(".name").value;
    var year = document.querySelector(".year").value;
    var color = document.querySelector(".color").value;
    obj = {
        id: data.length+1,
        name: name,
        year: year,
        color: color,
    }
    console.log("Oi",obj);
    data.push({id: data.length+1, name: name, year: year, color: color});
    
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

function update(){
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
    console.log(objeUpdate)
    var index = data.findIndex(rec => rec.id === id);
    data[index] = objeUpdate
    document.querySelector(".update_form").style.display = "none";
    readAll();
}

function deleteRecord(id){
    data = data.filter(rec => rec.id !== id);
    readAll();
}
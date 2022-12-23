let arregloUsuarios;
let existencia = false;

fetch("http://localhost:8080/usuarios")
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    arregloUsuarios = data;
    console.log(arregloUsuarios);
  })
  .catch((e) => {
    console.log(e);
  });

function obtenerActivo() {
  let correo = document.getElementById("exampleInputEmail1").value;
  let password = document.getElementById("exampleInputPassword1").value;
  fetch("http://localhost:8080/activo", {
    method: "DELETE",
  })
    .then((res) => res.text()) // or res.json()
    .then((res) => console.log(res));
  arregloUsuarios.forEach((element) => {
    if (element.correo == correo) {
      if (element.password == password) {
        let activo = new Object();
        activo.id_usuario = element.id;
        alert("Sesion iniciada con exito");
        fetch("http://localhost:8080/activo", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(activo),
        })
          .then((response) => response.json())
          .then((data) => {
            console.log("Success:", data);
            window.location.href = "http://localhost:8080/index.html";
          })
          .catch((error) => {
            console.error("Error:", error);
          });
      }
    }
  });
}

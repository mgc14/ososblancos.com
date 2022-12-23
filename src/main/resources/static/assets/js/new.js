let arregloUsuarios;
let existencia = false;

fetch("https://proyectointegrador-production-75ae.up.railway.app/usuarios")
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
  fetch("https://proyectointegrador-production-75ae.up.railway.app/activo", {
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
        fetch("https://proyectointegrador-production-75ae.up.railway.app/activo", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(activo),
        })
          .then((response) => response.json())
          .then((data) => {
            console.log("Success:", data);
            window.location.href = "https://proyectointegrador-production-75ae.up.railway.app/index.html";
          })
          .catch((error) => {
            console.error("Error:", error);
          });
      }
    }
  });
}

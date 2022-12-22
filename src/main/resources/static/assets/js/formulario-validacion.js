const nombre = document.getElementById("name");
const email = document.getElementById("email");
const pass = document.getElementById("password");
const passDos = document.getElementById("passDos");
const form = document.getElementById("form");
const parrafo = document.getElementById("warnings");

let repetido = false;
let arregloUsuarios;
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

form.addEventListener("submit", (e) => {
  e.preventDefault();
  let warnings = "";
  let entrar = false;
  let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  parrafo.innerHTML = "";
  if (nombre.value.length < 6) {
    warnings += `El nombre no es válido <br>`;
    entrar = true;
  }
  if (!regexEmail.test(email.value)) {
    warnings += `El email no es válido <br>`;
    entrar = true;
  }
  if (pass.value.length < 8) {
    warnings += `La contraseña no es válida <br>`;
    entrar = true;
  }
  if (passDos.value !== pass.value) {
    warnings += `La contraseña no es igual <br>`;
    entrar = true;
  }
  if (entrar) {
    parrafo.innerHTML = warnings;
  } else {
    let data = {
      correo: `${email.value}`,
      nombre_completo: `${nombre.value}`,
      password: `${pass.value}`,
    };
    let correoExistente;
    let correoEntrante;

    for (let index = 0; index < arregloUsuarios.length; index++) {
      correoExistente = arregloUsuarios[index].correo;
      correoEntrante = email.value;
      if (correoExistente == correoEntrante) {
        repetido = true;
        break;
      }
    }

    if (repetido) {
      parrafo.innerHTML = "El correo electronico ya está registrado";
    } else {
      fetch("http://localhost:8080/usuarios", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("Success:", data);
        })
        .catch((error) => {
          console.error("Error:", error);
        });
      window.location.href = "sucessregister.html";
      parrafo.innerHTML = "Enviado";
    }
  }
});

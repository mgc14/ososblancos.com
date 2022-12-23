let arregloProductos;

fetch("http://localhost:8080/productos")
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    arregloProductos = data;
    desplegar();
  })
  .catch((e) => {
    console.log(e);
  });

function desplegarFiltro(filtro) {
  document.getElementById("productos_despliegue").innerHTML = "";
  arregloProductos.forEach((element) => {
    if (filtro == element.categoria) {
      const box = document.createElement("div");
      box.classList = "card m-4 shadow";
      box.innerHTML = `
    
    <a href="#" onclick="agregarCarrito(${element.id})">
    <img
    src="${element.imagen_frontal}"
    class="card-img-top"
    height="150"
    alt="chocho1"
    />
    </a>
    <div class="card-body" >
    <p class="card-text fw-bold">${element.marca}</p>
    <small class="text-secondary "> ${element.precio}.00 </small>
    </div>
    `;
      document.getElementById("productos_despliegue").appendChild(box);
    }
  });
}
function desplegar() {
  document.getElementById("productos_despliegue").innerHTML = "";
  arregloProductos.forEach((element, index) => {
    const box = document.createElement("div");
    box.classList = "card m-4 shadow";
    box.innerHTML = `
    
    <a href="#" onclick="agregarCarrito(${element.id})">
    <img
    src="${element.imagen_frontal}"
    class="card-img-top"
    height="150"
    alt="chocho1"
    />
    </a>
    <div class="card-body" >
    <p class="card-text fw-bold">${element.marca}</p>
    <small class="text-secondary "> ${element.precio} </small>
    </div>
    `;
    document.getElementById("productos_despliegue").appendChild(box);
  });
}

function agregarCarrito(id) {
  if (confirm("¿Agregar producto a carrito?")) {
    arregloProductos.forEach((element) => {
      if (element.id == id) {
        let carritoProducto=new Object();
        carritoProducto.id_producto = id;
        carritoProducto.precio = element.precio;
        carritoProducto.marca = element.marca;
        carritoProducto.imagen_frontal = element.imagen_frontal;
        carritoProducto.imagen_nutricional = element.imagen_nutricional;
        carritoProducto.categoria = element.categoria;
        fetch("http://localhost:8080/carrito", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(carritoProducto),
        })
          .then((response) => response.json())
          .then((data) => {
            console.log("Success:", data);
          })
          .catch((error) => {
            console.error("Error:", error);
          });
      } else {
      }
    });
  }
}

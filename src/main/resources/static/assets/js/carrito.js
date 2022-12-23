let arregloCarrito;
let precioTotal = 0;
let iva = 0;
let precioEnvio = 0;
let precioFinal = 0;

let direccion = "";
let usuarioActivo;

fetch("http://localhost:8080/carrito")
	.then((response) => {
		return response.json();
	})
	.then((data) => {
		arregloCarrito = data;
		desplegarCarrito();
	})
	.catch((e) => {
		console.log(e);
	});

function desplegarCarrito() {
	precioTotal = 0;
	iva = 0;
	precioEnvio = 0;
	precioFinal = 0;
	document.getElementById("carrito_despliegue").innerHTML = "";
	for (let index = 0; index < arregloCarrito.length; index++) {
		const box = document.createElement("div");
		box.classList = "card mb-3";
		box.style = "max-height: auto;";
		box.innerHTML = `
    


    <div class="row g-0">
    <div class="col-md-4">
    <!-- El siguiente id cambia  -->
    <div id="carouselExampleControls${index}" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
    <div class="carousel-item active">
    <!-- Primer Imagen de producto 1 -->
    <img src="${arregloCarrito[index].imagen_frontal}"
    class="img-fluid rounded-start" alt="Suplemento">
    </div>
    <div class="carousel-item">
    <img src="${arregloCarrito[index].imagen_nutricional}" 
    class="d-block w-100" alt="...">
    </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls${index}" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls${index}" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
    </button>
    </div>
    </div>
    <div class="col-md-8">
    <div class="card-body">
    <h5 class="card-title">Precio</h5>
    <p class="card-text">${arregloCarrito[index].precio}</p>
    </div>
    </div>
    </div>
    `;
		document.getElementById("carrito_despliegue").appendChild(box);
		if (!document.getElementById("carrito_despliegue").innerHTML == "") {
			precioEnvio = 99;
		}
		precioTotal += arregloCarrito[index].precio;
	}
	iva = (precioTotal / 100) * 16;
	precioFinal = precioTotal + iva + precioEnvio;
	document.getElementById("precio_total").innerHTML =
		"$" + precioTotal.toFixed(2);
	document.getElementById("precio_iva").innerHTML = "$" + iva.toFixed(2);
	if (precioTotal + iva > 1500) {
		precioEnvio = 0;
	}
	document.getElementById("precio_envio").innerHTML =
		"$" + precioEnvio.toFixed(2);
	document.getElementById("precio_final").innerHTML =
		"$" + precioFinal.toFixed(2);
}

function fetchActivo(){
	fetch("http://localhost:8080/activo")
	.then((response) => {
		return response.json();
	})
	.then((data) => {
		usuarioActivo = data;
		console.log(usuarioActivo);
		console.log(usuarioActivo[0].id_usuario);
	})
	.then(()=>{
		if (!Object.keys(usuarioActivo).length===0) {
			arregloCarrito.forEach((element) => {
				let orden = new Object();
				orden.direccion = direccion;
				orden.id_producto = element.id_producto;
				orden.id_usuario = usuarioActivo[0].id_usuario;
				orden.precio_final = precioFinal;
				fetch("http://localhost:8080/ordenes", {
					method: "POST",
					headers: {
						"Content-Type": "application/json",
					},
					body: JSON.stringify(orden),
				})
					.then((response) => response.json())
					.then((data) => {
						console.log("Success:", data);
					})
					.catch((error) => {
						console.error("Error:", error);
					});
			});
		}	
	})
	.catch((e) => {
		console.log(e);
	});
}

function enviarOrden() {
	direccion += document.getElementById("calle").value + " ";
	direccion += document.getElementById("colonia").value + " ";
	direccion += document.getElementById("estado").value;
	fetchActivo();
	

	

	fetch("http://localhost:8080/carrito", {
		method: "DELETE",
	})
		.then((res) => res.text()) // or res.json()
		.then((res) => console.log(res));
	alert("Orden colocada\n¡Gracias por comprar en Royal Bear!")
	window.location.href = "http://localhost:8080/carrito.html"
}

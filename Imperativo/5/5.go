package main

import (
	"fmt"
	"slices"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

var lProductos listaProductos

var lMinimos listaProductos

const existenciaMinima int = 10 //la existencia mínima es el número mínimo debajo de el cual se deben tomar eventuales desiciones

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	for i := 0; i < len(*l); i++ {
		if nombre == (*l)[i].nombre {
			(*l)[i].cantidad++
			return
		}
	}
	*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
}

func (l *listaProductos) agregarProductos(productos ...producto) {
	for _, product := range productos {
		*l = append(*l, producto{nombre: product.nombre, cantidad: product.cantidad, precio: product.precio})
	}
}

func (l *listaProductos) buscarProducto(nombre string) (*producto, int) { //el retorno es el índice del producto encontrado y -1 si no existe
	var error int
	var i int
	var p *producto
	var verificator = false
	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			p = &(*l)[i]
			verificator = true
		}
	}

	if verificator {
		error = 0
		return p, error
	} else {
		error = 1
		return p, error
	}
}

func (l *listaProductos) venderProducto(nombre string) {
	var prod, e = l.buscarProducto(nombre)
	if e == 1 {
		println("error en la búsqueda")
		return
	} else {
		(*prod).cantidad = (*prod).cantidad - 1
	}
}

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)

}

func listarProductosMínimos() listaProductos {
	return lMinimos
}

// puntero a lista total, parametros a lista de minimos
func (l *listaProductos) refreshMinimum(x *listaProductos) {
	comp := true

	for i := 0; i < len(*l); i++ {
		if (*l)[i].cantidad < existenciaMinima {
			for z := 0; z < len(*x); z++ {
				if (*l)[i].nombre == (*x)[z].nombre {
					comp = false
				}
			}
			if comp {
				*x = append(*x, (*l)[i])
			}
			comp = true
		} else {
			for z := 0; z < len(*x); z++ {
				if (*l)[i].nombre == (*x)[z].nombre {
					(*x).remove(z, lMinimos)
				}
			}
		}
	}
	return
}

func (l *listaProductos) remove(i int, s listaProductos) {
	s[i] = s[len(s)-1]
	*l = s[:len(s)-1]
	return
}

// Puntero a minimos, parametro a lista total
// Ejercicio 5 parte a
func (l *listaProductos) aumentarInventarioDeMinimos(z *listaProductos) {
	var x *listaProductos = &lMinimos
	lProductos.refreshMinimum(x)

	for i := 0; i < len(*l); i++ {
		for y := 0; y < len(*z); y++ {
			if (*z)[y].nombre == (*l)[i].nombre {
				(*z)[y].cantidad = existenciaMinima
			}
		}
	}
	return
}

func main() {
	llenarDatos()
	fmt.Println(lProductos)
	lProductos.venderProducto("arroz")
	fmt.Println(lProductos)
	var l *listaProductos = &lMinimos
	lProductos.refreshMinimum(l)

	//Ejercicio 5 parte b
	fmt.Println(lProductos)
	slices.SortFunc(lProductos, func(a, b producto) int {
		if a.cantidad < b.cantidad {
			return -1
		}
		if b.cantidad < a.cantidad {
			return 1
		}
		return 0

	})
	fmt.Println(lProductos)
}

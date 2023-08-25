// 3
package main

import (
	"fmt"
)

type stringlist []string

var sList stringlist

func (temp *stringlist) rearrange(movements int, direction int) {
	fmt.Println("Lista antes de los movimientos: ", temp)
	//lógica: por cada ciclo for pasar el primer elemento a la posición del segundo hasta llegar al último para ponerlo en la posición del primer elemento
	storage1 := ""
	storage2 := ""
	if direction == 1 { //Movimientos a la izquierda
		for i := 0; i < movements; i++ {
			storage1 = (*temp)[len(*temp)-1]
			for z := 0; z < len(*temp); z++ {
				storage2 = (*temp)[z]
				(*temp)[z] = storage1
				storage1 = storage2
			}
		}
	} else {
		for i := 0; i < movements; i++ { //Movimientos a la derecha
			storage1 = (*temp)[0]
			for z := len(*temp) - 1; z >= 0; z-- {
				storage2 = (*temp)[z]
				(*temp)[z] = storage1
				storage1 = storage2
			}
		}

	}
	fmt.Println("Lista después de los movimientos: ", temp)

}
func fillData() {
	sList = append(sList, "a")
	sList = append(sList, "b")
	sList = append(sList, "c")
	sList = append(sList, "d")
	sList = append(sList, "e")
	sList = append(sList, "f")
	sList = append(sList, "g")
	fmt.Println("Datos ingresados con éxito")
}
func main() {
	fillData()
	sList.rearrange(3, 0)

}

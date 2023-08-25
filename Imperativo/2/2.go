// 2
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Println("Ingrese la cantidad de elementos de la línea del centro, debe ser impar positivo: ")
	scanner.Scan()

	userInput := scanner.Text()

	number, err := strconv.Atoi(userInput)
	if err != nil {
		fmt.Println("No se ingresó un número")
		return
	}
	if number%2 == 0 {
		fmt.Println("El número no es par")
		return
	}
	if number < 0 {
		fmt.Println("El número es negativo")
		return
	}

	spaces := ((number + 1) / 2)
	quantity := 1
	checker := false
	for quantity > 0 {
		for i := 0; i < spaces; i++ {
			fmt.Print(" ")
		}
		for i := 0; i < quantity; i++ {
			fmt.Print("*")
		}
		if quantity == number {
			checker = true

		}
		if checker {
			quantity -= 2
			spaces++
		} else {
			quantity += 2
			spaces--
		}
		fmt.Print("\n")

	}
	return

}

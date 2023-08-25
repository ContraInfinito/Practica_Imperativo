package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println("Ingrese el texto (use ctrl + z en windows para terminar): ")
	reader := bufio.NewReader(os.Stdin)
	var userInputBuilder strings.Builder
	for {
		line, err := reader.ReadString('\n')

		if err != nil {
			break
		}

		userInputBuilder.WriteString(line)
	}

	userInput := userInputBuilder.String()

	fmt.Println("Dato ingresado:", userInput)
	charcount := len(userInput)
	fmt.Println("Número de carácteres: ", charcount)

	userInput = strings.ToLower(userInput)

	var wordcount int
	wordcount = 0

	for _, char := range userInput {
		if char >= 'a' && char <= 'z' {
			wordcount++
		}
	}
	fmt.Println("Número de letras: ", wordcount)

	fmt.Println("Número de lineas: ", len(strings.Split(userInput, "\n"))-1)
}

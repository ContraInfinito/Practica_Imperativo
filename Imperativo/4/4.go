// 4
package main

import (
	"fmt"
)

type shoe struct {
	model string
	price int
	fit   int
}

type shoelist []shoe

var shoeL shoelist

type stock struct {
	model string
	stock int
	fit   int
}

type stocklist []stock

var stockL stocklist

func (temp *shoelist) addshoes(newS shoe) {
	if newS.fit < 34 || newS.fit > 44 {
		fmt.Println("El zapato no puede tener una talla menor a 34 ni mayor a 44")
		return
	}

	for i := 0; i < len(*temp); i++ {
		if (*temp)[i].model == newS.model && (*temp)[i].fit == newS.fit {
			stockL.addstock(newS)
			return
		}
	}
	*temp = append(*temp, newS)
	stockL.addstock(newS)

	fmt.Println("Zapato agregado con éxito")
}

func (temp *stocklist) addstock(newS shoe) {
	for i := 0; i < len(*temp); i++ {
		if (*temp)[i].fit == newS.fit && (*temp)[i].model == newS.model {
			(*temp)[i].stock++
			return
		}
	}
	*temp = append(*temp, stock{newS.model, 1, newS.fit})
	return

}

func (temp *shoelist) sell(shoeS shoe) {
	for i := 0; i < len(*temp); i++ {

		if (*temp)[i].model == shoeS.model && (*temp)[i].fit == shoeS.fit {
			stockL.innersell(shoeS)
			return
		}
	}
	fmt.Println("El zapato no existe")
}

func (temp *stocklist) innersell(shoeS shoe) {
	for i := 0; i < len(*temp); i++ {
		if (*temp)[i].model == shoeS.model && (*temp)[i].fit == shoeS.fit {
			if (*temp)[i].stock >= 1 {
				(*temp)[i].stock--
				fmt.Println("Zapato vendido con éxito")
				fmt.Println("Lista actual de stock: ", stockL)
				return
			} else {
				fmt.Println("No hay stock restante de este zapato")
				return
			}
		}
		fmt.Println("Error: zapato no en la lista de stock")
	}
}

func burn() {
	shoeL.addshoes(shoe{"Nike Cortez", 60000, 42})
	shoeL.addshoes(shoe{"Adidas Samba", 50000, 35})
	shoeL.addshoes(shoe{"Nike Blazer", 105000, 44})
	shoeL.addshoes(shoe{"Licenciado Valeriano", 15000, 38})
	shoeL.addshoes(shoe{"Jordan 1", 130000, 43})
	shoeL.addshoes(shoe{"Puma Soccer", 32000, 39})
	shoeL.addshoes(shoe{"Nike Air Force", 100000, 36})
	shoeL.addshoes(shoe{"Jordan Luka 2", 135000, 42})
	shoeL.addshoes(shoe{"Kobe 6", 90000, 37})
	shoeL.addshoes(shoe{"Li Ning Wade 8", 120000, 44})
	shoeL.addshoes(shoe{"Nike Cortez", 60000, 42})
	shoeL.addshoes(shoe{"Adidas Samba", 50000, 45})
	shoeL.addshoes(shoe{"Jordan 4", 60000, 31})
}

func main() {
	burn()
	shoeL.sell(shoe{"Nike Cortez", 60000, 42})
	shoeL.sell(shoe{"Nike Cortez", 60000, 42})
	shoeL.sell(shoe{"Nike Cortez", 60000, 42})

}

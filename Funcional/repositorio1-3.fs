//1
let shift direction n list =
    let length = List.length list
    let n' = n % length // Ensure n is within the proper range
    
    match direction with
    | "left" ->
        let firstPart = List.take (length - n') list
        let secondPart = List.replicate n' 0
        secondPart @ firstPart
    | "right" ->
        let firstPart = List.replicate n' 0
        let secondPart = List.take (length - n') list
        firstPart @ secondPart
    | _ -> failwith "Invalid direction"

// Examples of usage
let result1 = shift "left" 3 [1;2;3;4;5]
let result2 = shift "right" 2 [1;2;3;4;5]
let result3 = shift "left" 6 [1;2;3;4;5]

printfn "%A" result1 // Should print [4; 5; 0; 0; 0]
printfn "%A" result2 // Should print [0; 0; 1; 2; 3]
printfn "%A" result3 // Should print [0; 0; 0; 0; 0]

//2
let filterSubstrings substring list =
    let containsSubstring str = 
        String.contains substring str
    
    List.filter containsSubstring list

// Example of usage
let result = filterSubstrings "la" ["la casa"; "el perro"; "pintando la cerca"]

printfn "%A" result // Should print ["la casa"; "pintando la cerca"]



//3
let n_esimo n lista =
    let indices = [0..(List.length lista - 1)] // Lista de índices
    let elementosConIndices = List.zip indices lista // Combinar índices y elementos

    let elementoDeseado =
        List.head (List.map (fun (index, elem) -> if index = n then Some elem else None) elementosConIndices)

    match elementoDeseado with
    | Some result -> result // Si se encuentra un elemento, devolverlo
    | _ -> false // Si no se encuentra o hay duplicados, devolver false

// Ejemplos de uso
let resultado1 = n_esimo 2 [1;2;3;4;5]
let resultado2 = n_esimo 3 [1;2;3;4;5]
let resultado3 = n_esimo 6 [1;2;3;4;5]

printfn "%A" resultado1 // Debería imprimir 3
printfn "%A" resultado2 // Debería imprimir 4
printfn "%A" resultado3 // Debería imprimir false

//4
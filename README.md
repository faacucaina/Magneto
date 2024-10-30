# Parcial Magneto

## Introduccion
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

**isMutant(String[] dna)**

## Funcionamiento

Se recibirá como parámetro un array de Strings que representan cada fila de una tabla de (6x6) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Se sabrá si un humano es mutante, si se encuentra **MAS DE UNA SECUENCIA** de cuatro letras iguales, de forma oblicua, horizontal o vertical.

Las filas de la matriz a verificar se ingresan por teclado.

Ejemplo de input: '**ATCGTA**' (esto equivale a una fila de la matriz)

Una vez cargada correctamente la misma, se aplica una función que verifica si hay presencia en la matriz de mutantes o no y se devuelve el resultado al usuario en base a eso.

## Ejecución

El proyecto ha sido deployado a Render y puede ser accedido mediante el siguiente link:

https://parcial-magneto.onrender.com

### Endpoints

- **POST** /mutant - Recibe un JSON con la matriz de ADN a verificar. Ejemplo:

```json
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
```
- **GET** /stats - Devuelve un JSON con la cantidad de mutantes y humanos verificados. Ejemplo:

```json
{
    "count_mutant_dna": 40,
    "count_human_dna": 100,
    "ratio": 0.4
}
```

## Ejemplos de ADN

Ejemplo de matriz **MUTANTE**:

```json
{
    "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAAG",
      "CCCCTA",
      "TCACTG"
    ]
}
```

Ejemplo de matriz **NO MUTANTE**:

```json
{
    "dna": [
      "ATGGTG",
      "GTCTTA",
      "AATTGG",
      "ACTAGT",
      "GGATTC", 
      "AGGCAA"
    ]
}
```

## Pruebas Unitarias

Se incluyen casos de pruebas contemplando todos los patrones posibles (en filas, columnas y diagonales).

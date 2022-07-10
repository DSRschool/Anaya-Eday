const NO_ENCONTRADO = -1;

function busquedaLineal(lista, elemento) {
    for (let i = 0; i < lista.length; i++) {
        if (lista[i] == elemento) {
            return i; // return true;
        }
    }
    return NO_ENCONTRADO; // return false;
}

document.write(busquedaLineal([3, 8, 5, 7, 2], 7));
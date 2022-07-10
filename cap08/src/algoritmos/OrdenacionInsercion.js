function ordenacionInsercion(lista) {
   for (let i = 0, j; i < lista.length; i++) {
      let num = lista[i];
      for (j = i; j > 0 && num < lista[j-1] ; j--)
         lista[j] = lista[j-1];
      lista[j] = num;
   }
   return lista;
}

var ordenada = ordenacionInsercion([6, 3, 7, 5]);
document.write(ordenada);

function cribaEratostenes(limite) {
	let primos = [];
    let tachados = new Array(limite+1);
    tachados.fill(true, 0, 1);
    tachados.fill(false, 2);
	for (let i = 2; i*i < limite; i++) {
    	if (!tachados[i]) {
			for (let j = i*2; j <= limite; j += i) {
				tachados[j] = true;
			}
        }
    }
    for (let i = 0; i < tachados.length; i++) {
		if (!tachados[i]) {
			primos.push(i);
		}
	}
    return primos;
}

document.write(cribaEratostenes(100));
document.write("<br/>");
document.write(cribaEratostenes(100000000).length);
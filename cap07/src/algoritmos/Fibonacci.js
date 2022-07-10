function fib(lim) {
	let serie = [0, 1]; 
	let i = 2;
	let alcanzado = false; 
	while (!alcanzado) {
		let aux = serie[i-2] + serie[i-1];
		alcanzado = aux > lim;
		if (!alcanzado) {
			serie[i] = aux; 
		}
		i = i + 1; 
	}
	return serie; 
}
document.write(fib(1000));
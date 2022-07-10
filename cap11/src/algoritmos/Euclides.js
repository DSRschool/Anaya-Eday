function mcd(a, b) {
	let res;
	if (b == 0) {
		res = a;
	} else {
		res = mcd(b, a % b);
	}
	return res;
}

let res = mcd(48, 60);
document.write(res);
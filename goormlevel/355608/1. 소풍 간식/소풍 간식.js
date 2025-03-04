// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		const n = parseInt(line);
		
    const snackCount = Math.ceil(n / 2); // 과자의 개수
    const iceCount = Math.floor(n / 2);  // 아이스크림의 개수
		
		console.log(snackCount * iceCount);
		rl.close();
	}
	
	process.exit();
})();

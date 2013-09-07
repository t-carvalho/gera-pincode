object PinCodes {

	def toBase( from:BigInt, base:Array[Char]) : String = {
		var valor = from;
		var converted:String = ""
		val baseLen = base.length()

		while (valor > 0) {
			var resto = valor % baseLen;
			valor = valor / baseLen;
			converted += base.charAt(resto.toInt);
		}

		return converted.reverse
	}

	def main(args: Array[String]) {
		//if (args.length != 2) {}

		println("quais caracteres sao validos no pincode? (sem nenhum separador)")
		val baseString = readLine()
		println()

		// @todo remover chars duplicados

		println("quantos numeros voce quer gerar?")
		val generate:BigInt = readInt() + 1 // incremento 1 para não iniciar sempre com firstBase10
		println()

		println("qual sera o prefixo do pincode? (vazio para nenhum)")
		val prefix = readLine()
		println()

		println("quantos caracteres tera cada pincode? (sem contar o prefixo)")
		val pinCodeLen = readInt()
		println()

		val base = baseString.toCharArray
		val baseLen:BigInt = base.length()

		val firstBase10 = baseLen.pow(pinCodeLen - 1)
		val lastBase10  = baseLen.pow(pinCodeLen) - 1
		val countMaxBaseN = lastBase10 - firstBase10
		val distribute = countMaxBaseN / generate

		if (generate > countMaxBaseN) {
			println()
			println("impossivel gerar esta quantidade de pincodes")
			println("podemos gerar " + countMaxBaseN + " numeros com " + pinCodeLen + " caracteres na base " + baseLen + ".");
			println("para gerar " + generate + " numeros podemos usa a distribuicao " + distribute)
			System.exit(1)
		}

		val fileName = "pincodes-gerados.txt";
		println("os pincodes serao gerados no arquivo " + fileName)
		println()

		var rand = new scala.util.Random

		var current = firstBase10 + ( rand.nextInt(Integer.MAX_VALUE) % distribute );
		var generated = 1;

		val out  = new java.io.FileWriter(fileName)

		while (generated < generate) {
			out.write(prefix + toBase(current, base) + "\r\n")
			current += (rand.nextInt(Integer.MAX_VALUE) % distribute) + 1
			generated += 1
		}

		out.close

		println()
		println()
		println( "pincodes gerados!" );
	}

}
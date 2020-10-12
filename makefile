run:CipherKey.class
	java CipherKey $(ARGS)

CipherKey.class: CipherKey.java
	javac CipherKey.java

clean:
	rm *.class

help:
	@echo to decode: make run ARGS='decode ciphertext keyString'
	@echo to encode: make run ARGS='encode plaintext keyString'

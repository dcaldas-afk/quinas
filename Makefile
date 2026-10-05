SABLE = quinas.sable
SRC = src
BIN = bin
LEXER = QuinasLexer.java
LOG = log.txt

all:
	sablecc $(SABLE) -d $(SRC)
	mkdir -p $(BIN)
	javac -d $(BIN) $$(find $(SRC)/quinas -name "*.java") $(LEXER)
	cp $(SRC)/quinas/lexer/lexer.dat $(BIN)/quinas/lexer/

test:
	java -cp $(BIN) $(LEXER) $(T)

debug:
	java -cp $(BIN) $(LEXER) $(T) > $(LOG)

clean:
	rm -rf $(LOG) $(BIN) $(SRC)/quinas

re: clean all

.PHONY: all test clean re
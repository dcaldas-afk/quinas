SABLE = quinas.sable
SRC = src/quinas
BIN = bin

LEXER_DIR = $(BIN)/quinas/lexer
PARSER_DIR = $(BIN)/quinas/parser
TEST_DIR = tests/etapa3

D ?= sucesso
T ?= 18_soma_multiplicacao.qui

LEXER_OBJ = $(SRC)/lexer/lexer.dat
PARSER_OBJ = $(SRC)/parser/parser.dat

MAIN = $(SRC)/Main.java
DUMPER = $(SRC)/TreeDumper.java
PRINTER = $(SRC)/ASTPrinter.java
DISP = $(SRC)/ASTDisplay.java

LOG = Tree.txt

all:
	sablecc $(SABLE) -d src
	mkdir -p $(BIN)
	javac -encoding UTF-8 -cp $(BIN) -d $(BIN) -sourcepath src $(MAIN) $(DUMPER) $(PRINTER) $(DISPLAY)
	mkdir -p $(LEXER_DIR) $(PARSER_DIR)
	cp $(LEXER_OBJ) $(LEXER_DIR)
	cp $(PARSER_OBJ) $(PARSER_DIR)

display:
	java -cp $(BIN) quinas.Main $(TEST_DIR)/$(D)/$(T)
tree:
	java -cp $(BIN) quinas.TreeDumper $(TEST_DIR)/$(D)/$(T) > $(LOG)

clean:
	rm -rf $(BIN) $(LOG)

re: clean all

.PHONY: all tree display clean re
Rode um teste por vez.

01 @                  -> deve dar erro léxico
02 _                  -> deve dar erro léxico
03 $                  -> deve dar erro léxico
04 %                  -> deve dar erro léxico
05 coração            -> deve falhar ao chegar em ç/acentuação
06 12,                -> deve reconhecer 12 e falhar na vírgula
07 ,5                 -> deve falhar na vírgula
08 0b102              -> caso de borda: pode virar 0b10 + 2
09 /-- sem fechamento -> caso de borda: observe se fatia como / + comentário de linha
10 abc123             -> caso de borda: pode virar ID + NUMERAL_INT

Exemplo:
java -cp bin TesteLexer testes_invalidos_quinas/01_arroba.qui

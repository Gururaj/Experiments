
%{
#include <stdio.h>
#include "language.tab.h"

%}

%%

[0-9]+   yylval.number = atoi(yytext); return NUMBER; 
;        return SEMICOLON; 
\(        return OPEN; 
\)       return CLOSE;
,        return COMMA;
\+        yylval.string = strdup(yytext); return OPERATOR;
-        yylval.string = strdup(yytext); return OPERATOR;
\*        yylval.string = strdup(yytext); return OPERATOR;
\/        yylval.string = strdup(yytext); return OPERATOR;
[a-zA-Z]+         yylval.string = strdup(yytext); return FUNCTION;
\n              /* Ignore */
[ \t]           /* Ignore */
%%
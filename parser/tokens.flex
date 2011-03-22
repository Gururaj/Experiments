
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
[a-zA-Z]+         yylval.string = strdup(yytext); return FUNCTION; 
\n              /* Ignore */
[ \t]           /* Ignore */
%%
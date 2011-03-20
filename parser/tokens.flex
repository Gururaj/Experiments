
%{
#include <stdio.h>
#include "language.tab.h"

%}

%%

[0-9]+  {printf("Number\n"); return NUMBER; }
\(      return OPEN;
\)      return CLOSE;
[a-zA-Z]+       { printf("function\n"); return FUNCTION; }

%%
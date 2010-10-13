My adventures moving restEst to BuildR:

JEE 6 and maven1 repositories are not sweet friends of BuildR.

Glassfish has it's own repository at download.java.net/maven/glassfish.

My JRuby install uses is Ruby 1.8.7 compliant, which means that is ships with a bugged-to-hell REXML. This leads to a fatal "REXML::UndefinedNamespaceException : Undefined prefix xsi found" error. It also means that I can't do any more with JRuby, unless there's a 1.8.6 compliant version available... 

Trying Ruby 1.8.6.

Not awed yet.

Sourceforge is not letting me download mingw. This is not going well.

------

ok, mingw is down; gcc --version gives me a nice version output, gem install buildr gives me "gcc cannot be found".

Installed DevKit. God only knows what this is, but the Internet told me to use this. Why gem doesn't find gcc when it right there on my PATH, I don't know.

More fun:

In file included from load.c:31:0:
jniwrap.h:24:19: error: 'long long long' is too long for GCC
jniwrap.h:24:19: error: 'long long long' is too long for GCC
jniwrap.h:24:1: warning: useless type name in empty declaration
make: *** [load.o] Error 1

Why do I need a build-system (and a finicky and 'tardy one at that) to build me a build-system?

I wish JRuby didn't insist on shipping with a bugged REXML.
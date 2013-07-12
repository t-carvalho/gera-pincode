#include <iostream>
#include <algorithm>

using namespace std;

string converte(long long unsigned int valor)
{
    char chars[20] = {'2', '3', '7', '9', 'C', 'D', 'E', 'F', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'T', 'X', 'Y', 'Z'};
    int  base      = 20;
    
    string novaBase;

    long long unsigned int resto;

    while (valor > 0) {
        resto = valor % base;
        valor = valor / base;
        novaBase += chars[resto];
    }

    std::reverse(novaBase.begin(), novaBase.end());

    return novaBase;
}

int main ()
{
    long unsigned int gerar   = 22e6;
    long unsigned int gerados = 0;

    long long unsigned int decimal = 2.56e10;

    while (gerados < gerar) {

        cout << converte(decimal) << endl;

        gerados++;
        decimal++;
    }

    return 0;
}
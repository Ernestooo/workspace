/**
	PG1 - Ano: 16/17
	Ficha 2: Exerc�cio 3!
	Realizado por: Andr� Martins(43562), Bernardo Vale(43608), Jo�o Figueiredo(43500)
*/



import java.util.Scanner;

public class SpireGraph{
	public static void main(String[]args){
		Scanner keys = new Scanner(System.in);
		
		int[] ns = new int[10];//array inicial de 10 valores!
		int soma;//soma dos valores do array
		int n=0; //auxiliar para passar o array de strings para array de inteiros
		boolean erro=false;//flag auxiliar
		String[] temp;//array para ler, inicialmente, a sequ�ncia
		String t;//auxiliar
	
		
		//Input da sequ�ncia-----------------------------------------------------------------------------------
		do{
			//*Limpa a soma e o array, caso seja necess�rio introduzir uma nova sequ�ncia!*
			soma=0;
			for(int i =0 ; i<10; i++){
				ns[i]=0;
			}
			//-----------------------------------------------------------------------------
			
			System.out.println("Qual � a sequ�ncia?");
			String str = keys.nextLine();//Introduz a sequ�ncia numa vari�vel do tipo String
			str = str.trim();
			temp = str.split(" ");//Guarda os valores num array de strings
			
			//*Passa o array de strings para um array de Inteiros*
			for(int i = 0; i<temp.length; i++){
				t = temp[i];
				n=0;
				for(int w=t.length()-1, p=1 ; w>=0 ; w--, p*=10){
					n+=(t.charAt(w)-'0')*p;
				}
				ns[i]=n;
			}
			//-------------------------------------------------------
			
			//*Verifica se os valores introduzidos s�o v�lidos!*
			for(int i = 0; i<10 ; i++){
				if(ns[0]<0){
					erro=true;
					break;
				}
				if(ns[i]>=0 && ns[i]<=15){
					soma+=ns[i];
					erro=false;
				}
				else if(ns[i]>15){
					erro=true;
					break;
				}
				else if(soma>30){
					erro=true;
					break;
				}
				else{
					ns[i]=0;
					erro=false;
					break;
				}
			}
			//---------------------------------------------------
			
		}while(erro);//Caso haja algum valor inv�lido ele pede para introduzir nova sequ�ncia!
		//*----------------------------------------------------------------------------------------------------
		
		
		
		//-------------------- *Test: Print Array ns*-----------------
		System.out.print("[");
		for(int i = 0; i<10 ; i++){
			if(i<9){
				System.out.print(ns[i] + ", ");
			}
			else{
				System.out.print(ns[i] + "]");
			}
		}
		//*-----------------------------------------------------------
		
		
		//*C�lculo da altura m�x*---------------------------------
		System.out.println();
		int hMAX = ns[0]; //altura max
		int posM=0;
		for(int i=1; i<10 ; i++){
			if(hMAX < ns[i] && i<10){
				hMAX = ns[i];
				posM=i;
			}
		}
		/*System.out.println(hMAX + " " + posM);//s� para testar*/
		//*-------------------------------------------------------
		
		//*C�cula o n� de triangulos pedidos!*
		int nTriangs = 0;
		for(int i = 0; i<10 ; i++){
			if(ns[i]!=0){
				nTriangs++;
			}
			else{
				if(ns[i+1]!=0 || ns[i+2]!=0){
					nTriangs++;
				}
				else{
					break;
				}
				
			}
		}
		//*-----------------------------------
		
		int aux; //vari�vel auxiliar usada em (1)
		for(int i=hMAX+1 ; i>0 ; i--){//*Print das linhas*---------------------------------------------------------------
			System.out.println();
			for(int w = 0 ; w<10 ; w++){
				if(ns[w]==0 && ns[w+1]==0 && ns[w+2]==0){
					break;
				}
				if(ns[w]+1>=i){
					if(ns[w]+1==i){
						for(int outEspacos=ns[w]+1 ; outEspacos>0; outEspacos--){
							System.out.print(" ");
						}
						System.out.print("_");
						for(int outEspacos=ns[w]+1 ; outEspacos>0; outEspacos--){
							System.out.print(" ");
						}
					}
					else if(ns[w]==i){
						for(int outEspacos= ns[w] ; outEspacos>0 ; outEspacos--){
							System.out.print(" ");
						}
						System.out.print("/|\\");
						for(int outEspacos= ns[w] ; outEspacos>0 ; outEspacos--){
							System.out.print(" ");
						}
					}
					else{
						aux = ns[w]-i;//(1)aux = N�mero de espa�os no interior do tri�ngulo
						
						for(int a = aux; a<ns[w];a++){//D� os espa�os antes da primeira parede do tri�ngulo
							System.out.print(" ");
						}
						
						System.out.print("/");//Primeira parede do tri�ngulo
						
						for(int a = aux; a>0 ; a--){//D� os espa�os dentro da primeira parte do tri�ngulo
							System.out.print(" ");
						}
						
						System.out.print("|");//Meio do tri�ngulo
						
						for(int a = aux; a>0 ; a--){//D� os espa�os dentro da segunda parte do tri�ngulo
							System.out.print(" ");
						}
						
						System.out.print("\\");//Segunda parede do tri�ngulo
						
						for(int a = aux; a<ns[w];a++){//D� os espa�os a seguir � segunda parede do tri�ngulo
							System.out.print(" ");
						}
					}
				}
				//D� os espa�os em branco caso a linha ainda n�o seja onde o tri�ngulo come�a*
				else{
					for(int espacosGrandes=(ns[w]*2+3) ; espacosGrandes>0; espacosGrandes--){
						System.out.print(" ");
					}
				}
				//-----------------------------------------------------------------------------
			}
		}
		//*-----------------------------------------------------------------------------------------------------------------
		
		System.out.println();
		
		//*Apresenta a base dos tri�ngulos*------
		for(int i = 0; i<nTriangs ; i++){
			System.out.print("<");
			for(int w=0; w<(2*ns[i]+1) ; w++){
				System.out.print("=");
			}
			System.out.print(">");
		}
		//*--------------------------------------
		
		//*Apresenta a �ltima linha, onde apresenta os tra�os para definir onde come�a/acaba cada tri�ngulo*
		System.out.println();
		for(int i = 0; i<nTriangs ; i++){
			System.out.print(" ");
			for(int w=0; w<(2*ns[i]+1) ; w++){
				if(w==0 || w==(2*ns[i])){
					System.out.print("|");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.print(" ");
		}
		System.out.println();
		//*-------------------------------------------------------------------------------------------------
	}
}
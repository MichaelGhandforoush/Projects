// asm quicksort.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int arr[] = {14,5,4,-8};
	int temp;
	bool flag = true;
	int len = size(arr)-1;
	int tal = 0;
	int index = 0;
	//while (flag)
	//{
	//	flag = false;
	//	for (auto i = 0; i < sizeof(arr)/sizeof(arr[0]) - 1; i++)
	//	{

	//		if (arr[i + 1] < arr[i])
	//		{
	//			temp = arr[i];
	//			arr[i] = arr[i + 1];
	//			arr[i + 1] = temp;
	//			flag = true;
	//		}
	//	}

	//}
	__asm {
		mov ecx, 0
		mov ebx, 0


		while1:
				cmp tal, 1
				jg endwhile1
				mov tal, 2
				; ----- for loop -----
		if1:		
				cmp ecx, len
				jge endloop1
				inc ecx
					mov eax, arr[ebx] ; arr[i]
					mov edx, arr[ebx +4] ; arr[i+1]
					cmp edx, eax
					jge ifend1
					mov arr[ebx], edx
					mov arr[ebx+4], eax
					mov tal, 0
					add ebx, 4
					jmp if1
		ifend1:
				nop
				add ebx, 4
				jmp if1
		endloop1:
				nop
				mov ecx, 0
				mov ebx, 0
				jmp while1
		endwhile1:
				nop
				
				



	}
	for (auto i = 0; i < size(arr); i++)
	{
		cout << arr[i] << endl;
	}
}



#include <Windows.h>
#include <string>

#include <iostream>
using namespace std;
int main() {

	string dllpath = "C:\\Users\\YOUR_PATH\\Dll1.dll";
	DWORD procId = 18828;// DLL ENJEKTE EDILECEK PROCESS'IN ID'SI
	HANDLE handle = OpenProcess(PROCESS_ALL_ACCESS, false, procId);
	LPVOID LoadLibrary = (LPVOID)GetProcAddress(GetModuleHandle((LPCWSTR)"Kernel32.dll"), "LoadLibraryA");
	LPVOID Memory = (LPVOID)VirtualAllocEx(handle, NULL, dllpath.length() + 1, MEM_RESERVE | MEM_COMMIT, PAGE_READWRITE);
	WriteProcessMemory(handle, (LPVOID)Memory, dllpath.c_str(), dllpath.length() + 1, NULL);
	HANDLE RemoteThread = CreateRemoteThread(handle, NULL, NULL, (LPTHREAD_START_ROUTINE)LoadLibrary, (LPVOID)Memory, NULL, NULL);
	if (RemoteThread == NULL) {
		cout << "HATA(" << GetLastError() << ")" << endl;
	}
	else {
		cout << "BASARILI" << endl;
	}

	//hafizayi serbest birakiyoruz ve handle'i kapatiyoruz
	VirtualFreeEx(handle, (LPVOID)Memory, 0, MEM_RELEASE);
	CloseHandle(handle);
	

	return 1;
}

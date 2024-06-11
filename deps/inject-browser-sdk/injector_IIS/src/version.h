
#ifndef MAJ_VER
#define MAJ_VER 0
#endif

#ifndef MIN_VER
#define MIN_VER 99
#endif

#ifndef PATCH_VER
#define PATCH_VER 1
#endif

#define RC_FILE_VERSION MAJ_VER,MIN_VER,PATCH_VER,0

#define STRINGIFY(x) #x
#define TO_STRING(x) STRINGIFY(x)

#define FILE_VERSION_STRING TO_STRING(MAJ_VER.MIN_VER.PATCH_VER.0)

//In the name of God.
//The dependency finder of foriegn key constraints hsout.sql for postgresql
//Written by: Kian Mirjalali
#include <iostream>
#include <vector>
#include <set>
using namespace std;

template<class T>
inline int sz(const T& c) {
  return c.size();
}

#define fori(i,n) for (int i=0; i<(n); i++)
#define forv(i,v) fori(i, (sz(v)))

typedef string String;

inline bool startsWith(String s, String t, int beginIndex=0)
{
  if (sz(s)-beginIndex<sz(t))
	return false;
  forv(i,t)
	if (s[i+beginIndex]!=t[i])
	  return false;
  return true;
}

inline int indexOf(String s, String t, int beginIndex=0) {
  for (int i=beginIndex; i<sz(s); i++)
	if (startsWith(s, t, i))
	  return i;
  return -1;
}

inline string getSub(String s, int i, int j) {
  return (j<0) ? s.substr(i) : s.substr(i, j-i);
}

template<class C, class T>
inline bool contains(const C& c, const T& t) {
  return c.find(t) != c.end();
}

struct ForeignKey {
  string referringTable, constraint, columns, referredTable;
  
};

vector<ForeignKey> fkeys;
set<string> markedTables;

void printDeps(string tableName, string indent="") {
  markedTables.insert(tableName);
  //cout << indent << tableName << endl;
  forv(i, fkeys)
	if (fkeys[i].referredTable == tableName)
	  {
		string refing = fkeys[i].referringTable;
		cout << indent+"    " << refing << fkeys[i].columns << " ["+fkeys[i].constraint+"]";
		if (contains(markedTables, refing))
		  {
			cout << " @" << endl;
		  }
		else
		  {
			cout << ":" << endl;
			printDeps(refing, indent+"    ");
		  }
	  }
}

int main(int argc, char**argv) {
  if (argc != 2)
	{
	  cerr << argv[0] << " targetTableName" << endl;
	  return 1;
	}

  String targetTable = argv[1];

  const string s_alter = "alter table ";
  const string s_addCons = " add constraint ";
  const string s_fk = " foreign key ";
  const string s_refer = " references ";
  for (string l; getline(cin, l); )
	if (startsWith(l, s_alter))
	  {
		int i_addCons = indexOf(l, s_addCons, 0+sz(s_alter));
		if (i_addCons < 0)
		  continue;
		int i_fk = indexOf(l, s_fk, i_addCons+sz(s_addCons));
		if (i_fk < 0)
		  continue;
		int i_refer = indexOf(l, s_refer, i_fk+sz(s_fk));
		if (i_refer < 0)
		  continue;
		ForeignKey fk;
		fk.referringTable = getSub(l, 0+sz(s_alter), i_addCons);
		fk.constraint = getSub(l, i_addCons+sz(s_addCons), i_fk);
	    fk.columns = getSub(l, i_fk+sz(s_fk), i_refer);
		fk.referredTable = getSub(l, i_refer+sz(s_refer), -1);
		fkeys.push_back(fk);
	  }
  /*
  forv(i, fkeys)
	cerr << "'" << fkeys[i].referringTable << "' "
		 << "'" << fkeys[i].constraint << "' "
		 << "'" << fkeys[i].columns << "' "
		 << "'" << fkeys[i].referredTable << "'" << endl;
  */
  {
	bool bad=true;
	forv(i, fkeys)
	  if (fkeys[i].referredTable == targetTable || fkeys[i].referringTable == targetTable)
		{
		  bad=false;
		  break;
		}
	if (bad)
	  cerr << "Warning: table '"<< targetTable <<"' is never used in the constraint commands" << endl;
  }
  markedTables.clear();
  cout << targetTable << ":" << endl;
  printDeps(targetTable);
  
  return 0;
}

//In the name of God.
#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

typedef string String;
#define forv(i,v) for (int i=0; i<int((v).size()); i++)

	const int commands=3;
	const String command[] = {"create", "drop", "alter"};
	
	const String createTab = "create table";
	
	const String replacement[][3]= {
			{createTab, "blob", "longblob"},
			{createTab, "int4", "bigint"},
			{createTab, "int8", "bigint"},
			{"", "", ""}
		};

	template<class T>
	inline String toString(const T& x) {
		stringstream ss;
		ss << x;
		return ss.str();
	}

	inline String tolower(String s) {
		String t;
		forv(i, s)
			t+=tolower(s[i]);
		return t;
	}
	
	inline bool startsWith(String s, String t, int beginIndex=0)
	{
		if (int(s.length())-beginIndex<int(t.length()))
			return false;
		forv(i,t)
			if (s[i+beginIndex]!=t[i])
				return false;
		return true;
	}
	
	
	inline bool startsWithCommand(String str) {
		for (int i=0; i<commands; i++) {
			if (startsWith(str, command[i])) {
				return true;
			}
		}
		return false;
	}
	
	inline String noWhite(String str) {
		int i = 0;
		for (; i < int(str.length()); i++) {
			if (!isspace(str[i])) {
				break;
			}
		}
		return str.substr(i);
	}

	inline String replaceAll(String s, String a, String b) {
		String t="";
		forv (i, s)
			if (!startsWith(s, a, i))
				t+=s[i];
			else
				{
			t+=b;
			i+=a.size()-1;
				}
		return t;
	}
	
	
	inline bool isTokenEnd(char c) {
		if (isspace(c))
			return true;
		switch (c) {
		case ')':
		case '(':
		case ',':
			return true;
		}
		return false;
	}
	
	inline String nextToken(const String &s, int beginIndex=0) {
		String r = "";
		for (int i = beginIndex; i < int(s.length()) && !isTokenEnd(s[i]); i++) {
			r += s[i];
		}
		return r;
	}
	
	
	
	inline void error(String s) {
		cerr << s << "\r\n" << flush;
		exit(1);
	}

	vector<String> line, stmt;
	
	
	
	inline String getColName(String str, int i) {
		String pre = str.substr(0, i);
		reverse(pre.begin(), pre.end());
		String colName = nextToken(noWhite(pre));
		reverse(colName.begin(), colName.end());
		return colName;
	}
	
	const String geomCol = "AddGeometryColumn";
	const String geomColBegin = "[[";
	const String geomColEnd = "]]";
	
	
	inline void replaceGeomColumns(String str, vector<String> &res) {
		if (!startsWith(str, createTab)) {
			res.push_back(str);
			return;
		}

		String tableName = nextToken(noWhite(str.substr(createTab.size())));
		//cerr << tableName << endl;
		vector<bool> b(str.size(), true);
		
		vector<String> addGeomCol;
		//cerr << str << endl;
		
		forv(i, str) {
			if (b[i] && startsWith(str, geomCol, i)) {
				String columnName = getColName(str, i);
				//cerr << columnName << endl;
				
				int gcb = str.find(geomColBegin, i);
				if (gcb < 0 || gcb>=int(str.size()))
					error("Could not find '"+geomColBegin+"' in '"+str+"' after index "+toString(i)+".");
				gcb += geomColBegin.size();
				
				int gce = str.find(geomColEnd, gcb);
				if (gce < 0 || gce>=int(str.size()))
					error("Could not find '"+geomColEnd+"' in '"+str+"' after index "+toString(gcb)+".");
				//cerr << gcb << " " << gce << endl;
				
				String data = str.substr(gcb, gce-gcb);
				//cerr << data << endl;
				
				String addColStmt = "select AddGeometryColumn('"+tolower(tableName)+"', '"+columnName+"', "+data+")\n";
				//cerr << addColStmt << endl;
				addGeomCol.push_back(addColStmt);

				int delb = i;
				while (delb>=0 && str[delb]!=',' && str[delb]!='(')
					delb--;
				
				int dele = gce+geomColEnd.size();
				while (dele<int(str.size()) && str[dele]!=',' && str[dele]!=')')
					dele++;

				if (delb>=0 && str[delb]==',') {
					dele--;
				} else {
					delb++;
					if (dele>=int(str.size()) || str[dele]==')' )
						dele--;
				}
				
				for (int j = delb; j <= dele; j++) {
					b[j] = false;
				}
				
				/*
				forv(j, b)
					cerr << b[j];
				cerr << endl;
				//*/
			}
		}
		
		String newstr = "";
		forv(i, str) {
			if (b[i]) {
				newstr += str[i];
			}
		}
		//cerr << newstr << endl;
		
		res.push_back(newstr);
		forv(i, addGeomCol) {
			res.push_back(addGeomCol[i]);
		}
	}
	
	// ****************************
	
	
	inline void readLines() {
		String s;
		while (getline(cin, s))
			line.push_back(noWhite(s));
		/*
		for (int i=0; i<line.size(); i++)
			cerr << line[i] << endl;
		//*/
	}
	
	
	inline void makeStmts() {
		String s = "";
		for (int i = line.size(); i--;) {
			String l = line[i];
			s = l + "\n" + s;
			if (startsWithCommand(l)) {
				stmt.push_back(s);
				s = "";
			}
		}
		reverse(stmt.begin(), stmt.end());
	}
	
	
	inline void doReplacements() {
		forv (i, stmt) {
			for (int j=0; replacement[j][1].size()>0; j++) {
				if (startsWith(stmt[i], replacement[j][0])) {
					stmt[i] = replaceAll(stmt[i], replacement[j][1], replacement[j][2]);
				}
			}
		}
	}

	inline void correctCreate() {
//		forv(i, stmt) {
//			if (startsWith(stmt[i], "create table"))
//				stmt[i]+="type=innoDB CHARSET=utf8 ";
//		}
	}

	inline void replaceGeomColumns() {
		vector<String> res;
		forv(i, stmt)
			replaceGeomColumns(stmt[i], res);
		stmt = res;
	}
	
	
	inline void addSemicolons() {
		forv(i, stmt)
			stmt[i][stmt[i].length()-1]=';';
	}
	
	
	inline void addMoreNewLines() {
		forv(i, stmt) {
			int s = 0;
			
			for (int j = 0; j < int(stmt[i].length()); j++) {
				if (s > 100 && stmt[i][j] == ' ') {
					s = 0;
					stmt[i][j] = '\n';
				} else {
					s++;
				}
			}
		}
	}
	
	
	inline void output() {
		forv(i, stmt) {
			cout << stmt[i] << "\r\n" << flush;
		}
	}
	
	
	int main() {
		readLines();
		makeStmts();
		doReplacements();
		correctCreate();
		replaceGeomColumns();
		addSemicolons();
		addMoreNewLines();
		output();
		return 0;
	}

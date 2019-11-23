#!/bin/bash
#SCRIPT_PATH="$(dirname "$0")";
SCRIPT_PATH="$PWD/$(dirname "$0")"

# echo $SCRIPT_PATH;


TRUE=0
FALSE=1

function start(){
	local msg="$1";

	echo ;
	echo ;
	echo + $msg ...;
	echo ;
}

function end(){
	local msg="$1";

	echo ;
	echo + $msg OK.;
	echo ;
	echo ;
}


function test(){
	local value="$1";
	local message="$2";

	if [ "$value" != "$TRUE" ] ; then
		end "EXIT, Error: $message code:$value";
		
		exit  $FALSE;
	fi
}

function clean(){
	start "Cleaning"

	pushd "$SCRIPT_PATH";
	test "$?" "pushd "$repo"";

	find "$SCRIPT_PATH" -name \*~ -print -type f -exec rm {} \; ; 
	find "$SCRIPT_PATH" -name \*~ -print -type f -exec rm {} \; ; 
	find "$SCRIPT_PATH" -name .DS_Store -print -type f -exec rm {} \; ; 
	find "$SCRIPT_PATH" -name \#\*\# -print -type f -exec rm {} \; ;
	find "$SCRIPT_PATH" -name .#\* -print -exec rm {} \; ;

	popd;
	test "$?" "popd";

	end "Cleaning"

}

function gulpProd(){
	start "GULP PROD";

	pushd "$SCRIPT_PATH";
	test "$?" "pushd "$repo"";


	export NODE_PRODUCTION=true
	gulp dist
	test "$?" "gulp clean";


	popd;
	test "$?" "popd";

	end "GULP PROD";

}

function gitGetAndUpdate(){
	local msg="$1";
	
	start "GIT GET AND UPDATE"

	pushd "$SCRIPT_PATH";
	test "$?" "pushd "$repo"";
	
	echo 1/ git fetch origin
	git fetch origin
	test "$?" "git fetch origin";
	
	echo 2/ git merge origin/master
	git merge origin/master
	test "$?" "git merge origin/master";
	
	echo 3/ git add --all .
	git add --all .
	test "$?" "git add --all";
	
	echo 4/ git commit -a --allow-empty -m "$msg" --allow-empty-message
	git commit -a --allow-empty -m "$msg" --allow-empty-message
	test "$?" "git commit";
	
	echo 5/ git push origin master
	git push origin master
	test "$?" "git push origin master";


	popd;
	test "$?" "popd";

	end "GIT GET AND UPDATE"	
}

#
# Start here
#

clean ;

// gulpProd ;


if [ "$*"  != "" ] ; then
	MSG="$*";
else
    MSG="No msg";

fi


gitGetAndUpdate "$MSG";


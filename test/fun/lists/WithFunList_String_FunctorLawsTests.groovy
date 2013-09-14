/*
	* Copyright 2013 Robert Peszek.
	*
	* Licensed under the Apache License, Version 2.0 (the "License");
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	*     http://www.apache.org/licenses/LICENSE-2.0
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	*/
package fun.lists

import static fpig.common.functions.FpigBase.*
import static fpig.string.asfunlist.functions.InAndOutOfFunLists_forStrings.*
import static fpig.funlist.functions.BaseFL.*
import fpig.funlist.types.FunList;
import fpig.funlist.types.LazyList;
import fpig.string.asfunlist.functions.FunListToStringFunctor;

class WithFunList_String_FunctorLawsTests extends GroovyTestCase{

	
	void testWithFunList_ID_functorsyntax() {
		def fmap = FunListToStringFunctor.statics.fmap
		assert 'abc' == ( fmap (ID)) << 'abc'
	}

	
	void testWithFunList_composition() {
		def fmap = FunListToStringFunctor.statics.fmap
		
		assert 'abc' == (fmap (reverse << reverse)) << 'abc'
		assert 'abc' == (fmap (reverse)) << (fmap (reverse)) << 'abc'
	}
		
	void testWithFunList_composition2() {
		def fmap = FunListToStringFunctor.statics.fmap

		assert 'bd' == (fmap (filter{it !='c'} << filter{it != 'a'})) << 'abcd'
		assert 'bd' == (fmap (filter{it !='c'})) << (fmap (filter{it != 'a'})) << 'abcd'
	}

}

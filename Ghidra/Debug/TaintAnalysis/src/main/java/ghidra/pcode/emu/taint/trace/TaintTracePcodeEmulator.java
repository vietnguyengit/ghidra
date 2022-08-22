/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.pcode.emu.taint.trace;

import ghidra.pcode.emu.taint.TaintPartsFactory;
import ghidra.pcode.emu.taint.plain.TaintPcodeEmulator;
import ghidra.pcode.exec.trace.auxiliary.AuxTraceEmulatorPartsFactory;
import ghidra.pcode.exec.trace.auxiliary.AuxTracePcodeEmulator;
import ghidra.taint.model.TaintVec;
import ghidra.trace.model.Trace;

/**
 * A trace-integrated emulator with taint analysis
 */
public class TaintTracePcodeEmulator extends AuxTracePcodeEmulator<TaintVec> {
	/**
	 * Create an emulator
	 * 
	 * @param trace the trace the source trace
	 * @param snap the source snap
	 */
	public TaintTracePcodeEmulator(Trace trace, long snap) {
		super(trace, snap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Here, we just return the singleton parts factory. This appears simple because all the
	 * complexity is encapsulated in the factory. See {@link TaintPartsFactory} to see everything
	 * the implementation actually entails. Notice that this is the same parts factory used by
	 * {@link TaintPcodeEmulator}. The {@link AuxTracePcodeEmulator} knows to use the more capable
	 * state parts.
	 */
	@Override
	protected AuxTraceEmulatorPartsFactory<TaintVec> getPartsFactory() {
		return TaintPartsFactory.INSTANCE;
	}
}

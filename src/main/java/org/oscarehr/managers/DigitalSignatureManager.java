/**
 * Copyright (c) 2005-2012. Centre for Research on Inner City Health, St. Michael's Hospital, Toronto. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 * <p>
 * This software was written for
 * Centre for Research on Inner City Health, St. Michael's Hospital,
 * Toronto, Ontario, Canada
 */

package org.oscarehr.managers;

import org.oscarehr.common.model.DigitalSignature;
import org.oscarehr.common.model.enumerator.ModuleType;
import org.oscarehr.util.LoggedInInfo;

public interface DigitalSignatureManager extends OscarManagerBase {

    /**
     * Retrieves a digital signature from the database based on its ID.
     * <p>
     * This method retrieves the digital signature associated with the given `id` from the database.
     * The signature image, if present, is decrypted before being returned.  If the signature image
     * is not encrypted in the database (perhaps due to legacy data), this method attempts to encrypt
     * it and update the database for future access.
     *
     * @param id The ID of the digital signature to retrieve.
     * @return The retrieved `DigitalSignature` object, or `null` if no such entity exists or if an error occurs during
 *   * decrypting/encrypting the SignatureImage.
     */
    DigitalSignature getDigitalSignature(int id);

    /**
     * Saves a digital signature to the database.
     * <p>
     * This method saves a new digital signature to the database. The provided `imageData` is encrypted
     * before being stored. The digital signature is associated with the specified `facilityId`, `providerNo`,
     * and `demographicNo`.
     *
     * @param facilityId    The ID of the facility associated with the signature.
     * @param providerNo    The provider's number associated with the signature.
     * @param demographicNo The ID of the demographic entity associated with the signature.
     * @param imageData     The byte array representing the signature image.
     * @param moduleType    {@link ModuleType} The module from which the signature originated.
     * @return The saved `DigitalSignature` object, including the generated ID.
     * <p>Note, Encrypted imageData will be populated in the object returned.
     * @throws RuntimeException If an error occurs during encryption or saving the signature.
     */
    DigitalSignature saveDigitalSignature(Integer facilityId, String providerNo, Integer demographicNo, byte[] imageData, ModuleType moduleType);


    /**
     * Processes and saves a digital signature from a temporary file to the database.
     * <p>
     * This method retrieves a digital signature image from a temporary file, encrypts it,
     * and saves it to the database. The signature is associated with the logged-in user's
     * facility and provider number, as well as the specified `demographicNo`.
     * <p>
     * The `signatureRequestId` is used to locate the temporary signature file.  The method
     * checks if digital signatures are enabled for the current facility before proceeding.
     * If not enabled, the method returns `null`. It also handles the case where the
     * temporary signature file is not found, logging a debug message and returning `null`.
     *
     * @param loggedInInfo          Information about the currently logged-in user, used to
     *                              determine facility and provider details.
     * @param signatureRequestId    The ID used to locate the temporary signature image file.
     * @param demographicNo         The ID of the demographic entity associated with the signature.
     * @param moduleType            {@link ModuleType} The module from which the signature originated.
     * @return The saved `DigitalSignature` object, or `null` if digital signatures are
     *         disabled, the file is not found, or an error occurs during processing.
     */
    DigitalSignature processAndSaveDigitalSignature(LoggedInInfo loggedInInfo, String signatureRequestId, Integer demographicNo, ModuleType moduleType);

}

